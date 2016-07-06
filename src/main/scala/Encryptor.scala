package security

import java.io._
import scala.io._

/**
  * A simple command line encryption program.
  * Please do not use for anything other than demonstration purposes,
  * as this encryption algorithm is easily cracked by a 
  * cryptographer.
  */
object Encryptor {
	/**
	  * Encrypts a string of text.
	  */
	def encrypt(s: String): String = {
		val arr = s.getBytes.map((b: Byte) => b ^ 31) //converts string to Int Array and performs XOR on each element
		arr.map((i: Int) => i.toChar).map((c: Char) => c.toString).foldRight(""){ _ + _ } // converts to char and back to String
	}
	
	/** Adds padding to String to be encrypted.
	  */
	def padding: String = " 8724074202470832570287237 "
	
	/** Adds padding to String to be encrypted.
	  */
	def padding2: String = "u7838hshjdu4$#%#3783uhu"
	
	/**
	  * Reads the text from an input file and writes the
	  * encrypted text to an output file.
	  */
	def readFile(inFileName: String, outFileName: String) = {
		val fileWriter = new FileWriter(outFileName) // create new fileWriter
		
		val src = Source.fromFile(new File(inFileName)) // creats an iterator of type String
		val lines = src.getLines.toList // converts to a List
		for(l<-lines) { println(l) } // debug
		lines.map(s => fileWriter.write(encrypt(s))) // encrypts each element in the list and writes to file
		src.close // close source
		fileWriter.close // close writer
	}
	
	def main(args: Array[String]): Unit = {
		val in = args(0)
		val out = args(1)
		readFile(in, out)
	}
}
