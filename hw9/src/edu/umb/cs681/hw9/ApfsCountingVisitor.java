package edu.umb.cs681.hw9;

public class ApfsCountingVisitor implements ApfsVisitor{
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;
	
	
	public ApfsCountingVisitor() {}
	
	
	@Override
	public void visit(ApfsDirectory directory) {
		this.dirNum++;
	}
	
	@Override
	public void visit(ApfsFile file) {
		this.fileNum++;
	}
	
	@Override
	public void visit(ApfsLink link) {
		this.linkNum++;
	}
	
	
	public int getDirNum() {
		return this.dirNum;
	}
	
	
	public int getFileNum() {
		return this.fileNum;
	}
	
	public int getLinkNum() {
		return this.linkNum;
	}
	
	
	
}
