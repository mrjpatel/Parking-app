import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Configuration instance = null;
	
	private Properties props;
	
	private int parkingCost;
	
	/**
	 * Creates a single instance of Configuration File;
	 * @return instance of Configuration.
	 */
	public static Configuration getInstance(){
		if(instance == null){
			instance = new Configuration();
		}
		return instance;
	}
	
	/**
	 * Initialises Config File
	 * @param configFilePath filepath of the config file
	 */
	public void init(String configFilePath) {
		File configFile = new File(configFilePath);
		
		props = new Properties();
		try {
			props.load(new FileInputStream(configFile));
			
			this.parkingCost = Integer.parseInt(this.props.getProperty("parking.cost"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets parking Cost per car.
	 * @return cost of parking
	 */
	public int getParkingCost() {
		return parkingCost;
	}
}
