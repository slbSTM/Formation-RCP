package com.st.rental.rcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IAction quitAction;
	private IAction preferencesAction;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	{
    		quitAction = ActionFactory.QUIT.create(window);
    		register(quitAction);
    	}
    	{
    		preferencesAction = ActionFactory.PREFERENCES.create(window);
    		register(preferencesAction);
    	}
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	
    	MenuManager File = new MenuManager("New MenuManager");
    	File.setMenuText("File");
    	menuBar.add(File);
    	File.add(quitAction);
    	
    	MenuManager Window = new MenuManager("New MenuManager");
    	Window.setMenuText("Window");
    	menuBar.add(Window);
    	Window.add(preferencesAction);
    }
    
}
