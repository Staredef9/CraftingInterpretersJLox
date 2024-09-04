package com.craftinginterpreters.lox

import java.util.ArrayList; // equivalente ai vector in C++
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//static import in java is considered bad practice
//perche'? immagino perche' non si capisce 
//da dove viene il pezzo di codice che stai usando se lo nascondi 
import static com.craftinginterpreters.lox.TokenType.*;

class Scanner {

	private final	String 		source;
	private final	List<Token> 	tokens = new ArrayList<>();
	
	//grazie a questi si tiene traccia del char corrente 
	//e della linea a cui siamo nel momento dello scan
	//cosi il programma sa dove andare a pescare errori 
	//ecc 
	//comodo per il logging ed error handling
	//per segnalare all'utente le cose.
	private 	int	 	start = 0;
	private		int		current = 0;	
	private		int		line = 1;

	Scanner(String source){
		this.source = source;
	}
	
	List<Token> scanTokens(){
		while(!isAtEnd()){
			start = current;
			scanToken();
		}

		tokens.add(new Token(EOF, "", null, line));
		return tokens;
	}
	
	private boolean isAtEnd(){
		return current >= source.length();
	}
}
