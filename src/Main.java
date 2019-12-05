import controller.Controller;
import model.Model;

public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Model model = new Model();
		Controller controller = new Controller(model);
	}
}
