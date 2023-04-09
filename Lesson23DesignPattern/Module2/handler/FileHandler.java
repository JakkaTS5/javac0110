package Module2.handler;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;

public class FileHandler implements Runnable{
    private String dirPath;
    private LinkedBlockingQueue<String> queue;

    public FileHandler(String dirPath, LinkedBlockingQueue<String> queue) {
        this.dirPath = dirPath;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            //Tạo ra đối tượng quản lý thư mục
            File dir = new File(this.dirPath);

            //Lấy danh sách file trong thư mục
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                System.out.println("Read file processing....!");
                for (File file : files) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;
                        //Đọc từng dòng trong file đến hết
                        while ((line = br.readLine()) != null) {
                            queue.put(line);
                        }

                        br.close();
                        file.delete();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Read file DONE!");
            } else {
                System.out.println("Folder is empty!");
            }

            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
