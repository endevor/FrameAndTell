package edu.dartmouth.cs.frameandtell;
import java.util.Calendar;
import edu.dartmouth.cs.frameandtell.Story;

import android.text.InputType;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.text.Editable;


public class FrameandtellDialogFragments extends DialogFragment {
	private static final String DIALOG_ID_KEY = "dialog_id";
	public static final int DIALOG_ID_ERROR = -1;

	public static final int DIALOG_ID_IMAGE_PICKER = 1;
	public static final int DIALOG_DRAG_AND_DROP = 2;
	public static final int DIALOG_ENTER_TITLE = 3;

	// For photo picker selection:
	public static final int ID_PHOTO_PICKER_FROM_GALLERY = 1;
	public static final int ID_PHOTO_PICKER_FROM_CAMERA = 0;

	public static FrameandtellDialogFragments newInstance(int dialog_id) {
		FrameandtellDialogFragments frag = new FrameandtellDialogFragments();
		Bundle args = new Bundle();
		args.putInt(DIALOG_ID_KEY, dialog_id);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		final EditText textEntryView;

		int dialog_id = getArguments().getInt(DIALOG_ID_KEY);

		final Activity parent = getActivity();

		// Setup dialog appearance and onClick Listeners

		switch (dialog_id) {
		case DIALOG_ID_IMAGE_PICKER:
			AlertDialog.Builder builder = new AlertDialog.Builder(parent);
			builder.setTitle(R.string.Edit_panel_photo_picker_title);
			builder.setItems(R.array.Edit_panel_photo_picker_items, new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int item) 
				{
				//s	((EditPanelActivity)parent).onImagePickerItemSelected(item);

				}
			});					

			return builder.create();

		case DIALOG_ENTER_TITLE:
			textEntryView = new EditText(parent);
			textEntryView.setInputType(InputType.TYPE_CLASS_TEXT);
			textEntryView.setHint(R.string.story_input_title_hint);
			textEntryView.setLines(4);
			return new AlertDialog.Builder(parent)
			.setTitle(R.string.story_input_title_title)
			.setView(textEntryView)
			.setPositiveButton(R.string.story_save_title,
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
						int whichButton) {
					((Story)parent).onTitleSet(textEntryView.getText()
							.toString());

				}
			})
			.setNegativeButton(R.string.story_cancel_title,
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
						int whichButton) {
					textEntryView.setText("");
				}
			}).create();

		default:
			return null;
		}

	}
}