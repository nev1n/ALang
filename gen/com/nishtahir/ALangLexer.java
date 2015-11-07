// Generated from /Users/Nish/Developer/git/ALang/src/main/antlr4/com/nishtahir/ALang.g4 by ANTLR 4.5.1
package com.nishtahir;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ALangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, STRING_LITERAL=2, Identifier=3, LETTERS=4, NUMBERS=5, WS=6, LINE_COMMENT=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "STRING_LITERAL", "Identifier", "LETTERS", "NUMBERS", "WS", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "STRING_LITERAL", "Identifier", "LETTERS", "NUMBERS", "WS", 
		"LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ALangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ALang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t>\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\7\3\30\n\3\f\3\16\3\33\13\3\3\3\3\3\3\4\3\4\3\4\7\4\"\n\4\f\4\16\4%\13"+
		"\4\3\5\6\5(\n\5\r\5\16\5)\3\6\6\6-\n\6\r\6\16\6.\3\7\6\7\62\n\7\r\7\16"+
		"\7\63\3\7\3\7\3\b\3\b\7\b:\n\b\f\b\16\b=\13\b\2\2\t\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\3\2\6\4\2C\\c|\3\2\62;\5\2\13\13\16\16\"\"\4\2\f\f\17\17E"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\24\3\2\2\2\7\36\3\2\2\2\t\'\3\2\2\2\13"+
		",\3\2\2\2\r\61\3\2\2\2\17\67\3\2\2\2\21\22\7<\2\2\22\23\7?\2\2\23\4\3"+
		"\2\2\2\24\31\7)\2\2\25\30\5\t\5\2\26\30\5\13\6\2\27\25\3\2\2\2\27\26\3"+
		"\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3"+
		"\2\2\2\34\35\7)\2\2\35\6\3\2\2\2\36#\5\t\5\2\37\"\5\t\5\2 \"\5\13\6\2"+
		"!\37\3\2\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\b\3\2\2\2%#\3\2"+
		"\2\2&(\t\2\2\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\n\3\2\2\2+-"+
		"\t\3\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\f\3\2\2\2\60\62\t\4"+
		"\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2"+
		"\2\2\65\66\b\7\2\2\66\16\3\2\2\2\67;\7%\2\28:\n\5\2\298\3\2\2\2:=\3\2"+
		"\2\2;9\3\2\2\2;<\3\2\2\2<\20\3\2\2\2=;\3\2\2\2\13\2\27\31!#).\63;\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}