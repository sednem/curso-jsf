package br.ufpe.nti.ui.jsf;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthPhaseListener implements PhaseListener{
	private static final long serialVersionUID = 1L;

	//Método executado antes de uma fase
	@Override
	public void beforePhase(PhaseEvent pe) {
		System.out.println("Antes da fase: "
				+ pe.getPhaseId().toString() + " invoked.");
	}	
	//Método executado após uma fase
	@Override
	public void afterPhase(PhaseEvent pe) {
		System.out.println("Após da fase: "
				+ pe.getPhaseId().toString() + " invoked.");

		//Recupera a página da requisição
		FacesContext facesContext = pe.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();

		//Verifica se a página requisitada é login.jsf
		boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1);

		//Recupera o usuario da sessão
		HttpSession session = (HttpSession) 
				facesContext.getExternalContext().getSession(true);
		Object currentUser = session.getAttribute("currentUser");

		//Se não for tel delogin e não tiver usuário na sessão
		if (!isLoginPage && currentUser == null) {
			NavigationHandler nh = 
					facesContext.getApplication().getNavigationHandler();
			nh.handleNavigation(facesContext, null, "loginPage"); //retorna para a página de login
		}
	}
	//Utilizado para indicar em qual fase o nosso PhaseListener
	//será executado 
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
