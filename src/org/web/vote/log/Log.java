package org.web.vote.log;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Log{
    private long lastTimeFileSize = 0;
    private File logFile = new File("log.log");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    public void logMasssge(String megInfo) throws IOException {
        if(logFile == null){
            throw new IllegalStateException("logFile can not be null");
        }
        Writer writer = new FileWriter(logFile,true);
        writer.write(dateFormat.format(new Date()+"\t"+megInfo+"\n"));
    }
    public void logThread(final String mesInfo) throws IOException {
        //final File logFile = new File("log.log");
        if(!logFile.exists()){
            logFile.createNewFile();
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    new Log().logMasssge(mesInfo);
                    new Log().logView();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    public void logView() throws FileNotFoundException {
        final RandomAccessFile randomAccessFile = new RandomAccessFile(logFile,"rw");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    randomAccessFile.seek(lastTimeFileSize);
                    String str = "";
                    while ((str = randomAccessFile.readLine())!=null) {
                        System.out.println(new String(str.getBytes("utf-8")));
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
