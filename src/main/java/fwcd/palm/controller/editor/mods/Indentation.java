package fwcd.palm.controller.editor.mods;

import java.util.HashMap;
import java.util.Map;

import fwcd.palm.controller.editor.mods.EditorControllerModule;
import fwcd.palm.model.editor.PalmDocument;
import fwcd.palm.model.editor.PalmEditorModel;

public class Indentation implements EditorControllerModule {
	private final Map<String, String> indentors = new HashMap<>();
	private String indent;
	private String newBlockCloser = null;

	public Indentation() {
		indentors.put("{", PalmDocument.NEWLINE); // FIXME: Bug when indentation level is larger than 0
		indentors.put(":", "");

		setStyle(IndentationStyle.TABS);
	}

	public void setStyle(IndentationStyle style) {
		indent = style.get();
	}

	public void setStyle(String indent) {
		this.indent = indent;
	}

	@Override
	public void onInsert(String delta, int offset, PalmEditorModel editor) {
		if (delta.equals("\t")) {
			editor.removeSilentlyBeforeCaret(delta.length());
			editor.insertSilentlyBeforeCaret(indent);
		}

		String[] lines = editor.getLines();
		int caretLine = editor.getCaretLine();

		if (delta.endsWith(PalmDocument.NEWLINE)) {
			if (caretLine > 0) {
				String lastLine = lines[caretLine - 1];
				int indentationDepth = indentationDepth(lastLine);
				String indentation = "";

				for (int i=0; i<indentationDepth; i++) {
					indentation += indent;
				}

				editor.insertSilentlyBeforeCaret(indentation);
				if (newBlockCloser != null) {
					editor.insertSilentlyBeforeCaret(indent);
					editor.insertSilentlyAfterCaret(indentation + newBlockCloser);
				}
			}
			newBlockCloser = null;
		} else {
			newBlockCloser = null;

			for (String indentor : indentors.keySet()) {
				if (delta.endsWith(indentor)) {
					newBlockCloser = indentors.get(indentor);
				}
			}
		}
	}

	private int indentationDepth(String line) {
		if (line.startsWith(indent)) {
			if (line.length() > 1) {
				return 1 + indentationDepth(line.substring(indent.length()));
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}
}
