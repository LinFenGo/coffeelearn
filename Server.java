package Client;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9000);//完成通信监听
        while (true) {
            System.out.println("waiting");
            Socket s = ss.accept();
            BufferedReader bf = null;
            InputStream in = s.getInputStream();
            byte[] b = new byte[1024];
            int len = in.read(b);//block
            String str = new String(b);
            System.out.println(str);
            String a = str.substring(5, 12);
            String path = "/Users/apple/IdeaProjects/托尔斯泰/src/Client/" + a;
            FileReader fr = new FileReader(path);
            bf = new BufferedReader(fr);
            String string = bf.readLine();
            System.out.println(string);
            String bt = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html;charset=utf-8\n"
                    + "Context-Length " + string.getBytes().length + "\n" + "\n" + string;
            OutputStream out = s.getOutputStream();
            out.write((bt.getBytes(StandardCharsets.UTF_8)));
            out.flush();
            out.close();
        }
    }
}

        //           HttpServletRequest request = null;
  //          String a =request.getQueryString();
//            FileReader fr=null;
//            fr =new FileReader("/Users/apple/IdeaProjects/托尔斯泰/src/Client/xxx");
//            String str ;
//            str=bf.readLine();

//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(s.getInputStream()));

            // 进行普通IO操作
//            PrintStream ps =new PrintStream(s.getOutputStream());
//            ps.println();


