package com.st.rental.ui.cmd.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.opcoach.training.rental.Customer;

public class CopyCustomerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

	 	Clipboard clipboard = new Clipboard(Display.getCurrent());

	 	String textData = "";
	 	ISelection selection = HandlerUtil.getCurrentSelection(event);
	 	if (selection instanceof IStructuredSelection) {
	 		IStructuredSelection structuredSelection = (IStructuredSelection)selection;
	 		Object selectedObject = structuredSelection.getFirstElement();
 			if (selectedObject instanceof Customer) {
	 			textData = ((Customer)selectedObject).getDisplayName();
 			}
	 	}
		Object[] data = new Object[]{textData};

		TextTransfer textTransfer = TextTransfer.getInstance();
		Transfer[] transfers = new Transfer[]{textTransfer};

		clipboard.setContents(data, transfers);
		clipboard.dispose();

		return null;
	}

}
