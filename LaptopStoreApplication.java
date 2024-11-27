public class LaptopStoreApplication {
	
	public static Laptop[] laptopArray = new Laptop[30];
	
	public static void main(String[]args) {
		LaptopStoreFileInput.fillLaptops();
		launchTitleFrame();
	}
	
	public static void launchTitleFrame() {
		new LaptopStoreTitleFrame();
	}
}
