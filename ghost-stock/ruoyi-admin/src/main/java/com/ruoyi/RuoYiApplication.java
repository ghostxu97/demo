package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication {
	public static void main(String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(RuoYiApplication.class, args);
		System.out
				.println("  (♥◠‿◠)ﾉﾞ  鬼鬼瞄启动成功   ლ(´ڡ`ლ)ﾞ  \n" + "   _____ _    _  ____   _____ _________   ___    _ \n"
						+ "   / ____| |  | |/ __ \\ / ____|__   __\\ \\ / / |  | |\n"
						+ "  | |  __| |__| | |  | | (___    | |   \\ V /| |  | |\n"
						+ "  | | |_ |  __  | |  | |\\___ \\   | |    > < | |  | |\n"
						+ "  | |__| | |  | | |__| |____) |  | |   / . \\| |__| |\n"
						+ "   \\_____|_|  |_|\\____/|_____/   |_|  /_/ \\_\\\\____/");

	}
}