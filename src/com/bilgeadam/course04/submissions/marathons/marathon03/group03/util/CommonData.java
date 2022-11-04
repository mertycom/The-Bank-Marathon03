package com.bilgeadam.course04.submissions.marathons.marathon03.group03.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CommonData {
	private static final CommonData instance = new CommonData();
	private Properties props;
	private String propertiesFile;
	private Logger logger;
	private Scanner sc;

	private CommonData() {
		super();
	}

	public static CommonData getInstance() {
		return CommonData.instance;
	}

	public Scanner getScanner() {
		if (this.sc == null) {
			this.sc = new Scanner(System.in);
		}
		return this.sc;
	}

	private Properties getProperties() {
		if (this.props == null) {
			if (this.propertiesFile == null) {
				System.err.println("File is not defined");
				System.exit(404);
			}
			try (InputStream is = new FileInputStream(this.propertiesFile)) {
				this.props = new Properties();
				this.props.load(is);
			} catch (Exception e) {
				System.err.println("The file could not be read");
				System.exit(303);
			}
		}
		return this.props;
	}

	public void setPropertiesFile(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	public String getHibernateConfigFileName() {
		return this.getProperties().getProperty("hibernate.cfgFileName");
	}

	public String getEntityFilesLocation() {
		return this.getProperties().getProperty("hibernate.entity.filesLocationRoot");
	}

	public String getEntityPackageName() {
		return this.getProperties().getProperty("hibernate.entity.packageName");
	}

	private Logger getLogger() {
		if (this.logger == null) {
			this.logger = Logger.getLogger("My beautifull Logger");
			for (Handler handler : logger.getHandlers()) {
				handler.setLevel(Level.parse(this.getProperties().getProperty("logger.level")));
			}

			try {
				String logFileName = this.getProperties().getProperty("logger.fileName");
				FileHandler logFileHandler = new FileHandler(logFileName,
						Boolean.parseBoolean(this.getProperties().getProperty("logger.createNewEachTime")));
				logFileHandler.setFormatter(new SimpleFormatter());
				logFileHandler.setLevel(Level.parse(this.getProperties().getProperty("logger.level")));
				logger.addHandler(logFileHandler);
			} catch (Exception e) {
				System.err.println("Failed to create logger: " + e.getMessage());
				System.exit(1234);
			}
			logger.log(Level.INFO, "Logger created");
		}
		return this.logger;
	}

	public void basic(String message) {
		System.out.println(message);
	}

	public void info(String message) {
		this.getLogger().info("\t---> " + message);
	}

	public void warning(String message) {
		this.getLogger().warning("\t---> " + message);
	}

	public void error(String message) {
		this.getLogger().severe("\t---> " + message);
	}

}
