package edu.umb.cs681.hw9;

public interface ApfsVisitor {
	
	public void visit(ApfsLink link);
	public void visit(ApfsDirectory directory);
	public void visit(ApfsFile file);
	
}