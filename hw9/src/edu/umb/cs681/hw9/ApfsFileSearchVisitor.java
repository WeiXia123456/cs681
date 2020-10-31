package edu.umb.cs681.hw9;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsVisitor {

	private String filelName;
	
	private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();
	
	public ApfsFileSearchVisitor(String fileName) {this.filelName = fileName;}
	
	@Override
	public void visit(ApfsDirectory directory) {
		return;
	}
	
	@Override
	public void visit(ApfsFile file) {
		if(file.getName().equals(filelName)){
			foundFiles.add(file);
		}
		
	}
	
	@Override
	public void visit(ApfsLink link) {
		return;
	}
	
	public LinkedList<ApfsFile> getFoundFiles(){
		return this.foundFiles;
	}
	
}
