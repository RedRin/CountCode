package com.myUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CountSource {
	ArrayList<File> codeLists = new ArrayList<File>();
	
	private int normalLines = 0;
	private int commentLines = 0;
	private int whitespace = 0;

	public void count(File[] files) {
		
		for(int i=0; i<files.length; i++) {
			if(files[i].isDirectory()) {
				addFile(files[i]);
			} else {
				if(files[i].getName().matches(".*\\.cpp$")  || files[i].getName().matches(".*\\.cs") || files[i].getName().matches(".*\\.java")) {
					codeLists.add(files[i]);
				}
			}
		}
		
		Iterator<File> ite = codeLists.iterator();
		while(ite.hasNext()) {
			File fnext = ite.next();
			parse(fnext);
		}
		
	}
	
	private void parse(File fnext) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fnext));
			String lines = "";
			boolean comment = false;
			
			while((lines = br.readLine()) != null) {
							
				if(!comment) {
					if(lines.matches("^\\s*$")) {
						//����
						whitespace++;
					} 			
					else if(lines.matches("^[\\s]*//.*$")) {
						//   //ע��
						commentLines++;
					} 
					else if(lines.matches("^[\\s]*/\\*.*\\*/.*$")) { 
						//  /* */ ע��
						commentLines++;
					} else if(lines.matches("^[\\s]*/\\*.*$")) {
						//  /* �Ŀ�ʼ
						comment = true;
						commentLines++;
					} else {
						// ������
						normalLines++;
					}
				} else {
					//  */  �Ľ���
					commentLines++;
					if(lines.matches("^.*\\*/.*$")) {
						comment = false;
					}
				}
				
				
					
			}
					
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void addFile(File f) {
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for(File fchild : files) {
				if(fchild.isDirectory()) {
					addFile(fchild);
				}
				else {
					if(fchild.getName().matches(".*\\.h$") ||fchild.getName().matches(".*\\.cpp$")  || fchild.getName().matches(".*\\.cs$") || fchild.getName().matches(".*\\.java$")) {
						codeLists.add(fchild);
					}
				}
			}
		}
		
		
	}
	
	public int getWhitespace() {
		return whitespace;
	}
	
	public int getCommentLines() {
		return commentLines;
	}
	
	public int getNormalLines() {
		return normalLines;
	}
}
