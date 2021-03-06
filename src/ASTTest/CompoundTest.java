package ASTTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

import ast.ASTNode;
import ast.ASTParser;
import junit.framework.TestCase;

public class CompoundTest extends TestCase {
	private static ASTParser parser;
	@Test
	public void testCompound() {
		try {
			InputStream in = new FileInputStream(new File("Compoundinput.txt"));
			parser = new ASTParser(in);
			InputStream out = new FileInputStream(new File("Compoundoutput.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(out));
			ArrayList<String> expectedOutput = new ArrayList<String>();
			String temp;
			int count = 0;
			while((temp=br.readLine())!=null){
				expectedOutput.add(temp);
				count++;
			}
			int testNo = 0;
			while(testNo!=count){
				try {
					assertEquals(testNo+" "+expectedOutput.get(testNo),testNo+" "+parser.statementC(new ASTNode()).toSyntax());
					testNo++;
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
