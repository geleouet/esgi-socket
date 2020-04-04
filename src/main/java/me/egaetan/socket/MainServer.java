package me.egaetan.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {

	
	public static void main(String[] args) throws IOException {
		var socketServer = new ServerSocket(8080);
		
		
		Socket socket = socketServer.accept();
		var inputStream = new BufferedInputStream(socket.getInputStream());
		var scanner = new Scanner(inputStream);
		String firstLine = scanner.nextLine();
		
		String httpMethod = firstLine.split(" ")[0];
		System.out.println(httpMethod);
		
		String pathUrl = firstLine.split(" ")[1];
		System.out.println("Request " + pathUrl);
		
		var outputStream = new BufferedOutputStream(socket.getOutputStream());
		var writer = new PrintWriter(outputStream);
		String res = "<html>HelloWorld</html>";

		writer.println("HTTP/1.1 200 OK");
		writer.println("");
		writer.println(res);
		writer.flush();
		outputStream.flush();
		outputStream.close();
		
	}
}
