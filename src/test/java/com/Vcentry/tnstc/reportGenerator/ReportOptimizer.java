package com.Vcentry.tnstc.reportGenerator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ReportOptimizer {

	public static void optimizedReport() throws IOException {
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-dd hh-mm-ss-mmm");
		String name=df.format(date);
		File src = new File("C:\\Users\\91866\\workspace\\DataDrivenTest\\screenshot");
		File dst = new File("C:\\Users\\91866\\workspace\\DataDrivenTest\\oldScreenshot\\"+name);
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
		
	}
}
