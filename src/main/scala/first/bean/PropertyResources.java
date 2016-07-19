package first.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyResources {

	static Properties props = new Properties();

	static Log log = LogFactory.getLog(PropertyResources.class);

	static {
		load();
	}

	public static Properties load() {
		if (props.isEmpty()) {
			synchronized (props) {
				try {
					props.load(PropertyResources.class
							.getResourceAsStream("/jdbc.properties"));
					props.load(PropertyResources.class
							.getResourceAsStream("/common.config.properties"));
				} catch (Exception e) {
					log.error(e, e);
				}
			}
		}
		return props;
	}

	public static void addResource(String resource) {
		try {
			props.load(PropertyResources.class.getResourceAsStream(resource));
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	public static void addResource(File localFile) {
		try {
			props.load(new InputStreamReader(new FileInputStream(localFile),
					"UTF-8"));
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	public static void reload() {
		props.clear();
		load();
	}

	public static Properties getProps() {
		return props;
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

	public static Integer getInt(String key) {
		return Integer.valueOf(props.getProperty(key));
	}
}
