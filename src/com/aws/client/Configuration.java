package com.aws.client;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Configuration extends Properties {
	
	private static String configPath = "/etc/doclab";
	
	private static final String CONFIG_EXTENTION = "properties";

	private static Map<String,Configuration> _selfMap = new HashMap<String, Configuration>();

	private String configName = null;
	private static final long serialVersionUID = 1L;
	/**
	 * Default constructor. 
	 * never used normally.
	 */
	public Configuration(){
		super();
	}
	
	
	/**
	 * Initialize Configuration
	 */
	public static void Initialize(String configuration_path){
	    configPath = configuration_path;
	}
	
	
	/**
	 * Multiton interface will return instance of the selected configuration.
	 * 
	 * @param configurationName
	 * @return
	 */
	public static Configuration getInstance(String configurationName){
		
		if (_selfMap.get(configurationName) == null){
			Configuration config = new Configuration(); 
			config.configName = configurationName;
			config.reload();
			_selfMap.put(configurationName, config);
		}
		
		return _selfMap.get(configurationName);
	}
	
	/**
	 * getConfigPath will return the path of the config file for the selected configuration
	 * 
	 * @param configName
	 * @return
	 */
	public String getConfigPath(String configName){
	    if (configPath == null){
	        return "/"+configName + "." + CONFIG_EXTENTION;
	    }
		return configPath + "/" + configName + "." + CONFIG_EXTENTION;
	}
	
	
	/**
	 * Reload configuration from File..
	 * This will be synchronized to avoid race condition.
	 */
	public synchronized void reload(){
		try{
		    if (configPath == null){
		     System.out.println("Config File " + getConfigPath(configName));
		     load(getClass().getResourceAsStream(getConfigPath(configName)) ) ;
		    }else{
			File configFile = new File(getConfigPath(configName)); 
			FileReader reader = new FileReader(configFile);
			load(reader);
            reader.close();
		    }

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Thread safe write.
	 * @throws Exception
	 */
	
	public synchronized void write() throws Exception{
		write("");
	}
	

	/**
	 * Thread safe write with comments.
	 *  To lock config file from writing, simply add a new property
	 *  write_lock=true  
	 * @throws Exception
	 */
	public synchronized void  write(String comments) throws Exception{
		if (getProperty("write_lock")!= null && getProperty("write_lock").equals("true")){
			throw new Exception("Configuration cannot be written");
		}
		
		File configFile = new File(getConfigPath(configName));
		FileWriter writer = new FileWriter(configFile);
		store(writer, comments);
		writer.close();
	}

	/**
	 * Thread safe setProperty will set the property for the config.
	 */
	public synchronized Object setProperty(String key, String value){
		return super.setProperty(key, value);
	}

	/**
	 * Thread safe setProperty will get the property for the config (allows to set a default value)
	 */

	public synchronized String getProperty(String key, String defaultValue){
		return super.getProperty(key, defaultValue);
	}
	
	/**
	 * Thread safe setProperty will get the property for the config.
	 */
	public synchronized String getProperty(String key ){
		return super.getProperty(key );
	}
	
}
