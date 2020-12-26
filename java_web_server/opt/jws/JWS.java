import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class JWS {
    public static void main(String[] args) {
        int port;

        if(args.length < 1) {
            System.err.println("Error: Not enough arguments");
            System.exit(1);
        }

        port = Integer.parseInt(args[0]);
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("[+] Server listening on port " + port);
            while(true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getLocalAddress().getHostName() + " connected !");

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String userInput = in.readLine();
                String[] splitted = userInput.split(" ");

                String verb = splitted[0];
                String resource = splitted[1];
                String protocol = splitted[2];

                PrintStream output = new PrintStream(client.getOutputStream());
                if(verb.equals("GET")) {
                    URL url = new URL("http://sws.panda-crew.com/" + resource);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    BufferedReader inConn = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder HTMLContent = new StringBuilder();
                    while (!(inputLine = inConn.readLine()).contains("</html>"))
                        HTMLContent.append(inputLine+"\n");
                    inConn.close();
                    con.disconnect();
                    output.println("HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n\r\n" + HTMLContent);
                }

                client.close();
                System.out.println("Client " + client.getLocalAddress().getHostName() + " disconnected !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

