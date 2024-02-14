/* Generated By:JavaCC: Do not edit this line. MiniJavaParser.java */
import java.io.*;

public class MiniJavaParser implements MiniJavaParserConstants {

  public static void main(String[] args) throws ParseException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    SimpleCharStream stream = new SimpleCharStream(reader);
    MiniJavaParserTokenManager TkMgr = new MiniJavaParserTokenManager(stream);

    // Tells us whether the program is valid or not
    MiniJavaParser parser = new MiniJavaParser(TkMgr);
    boolean valid = false;
    try {
        parser.Program();
        valid = true;
    } catch (ParseException e) {
        System.out.println("Program is not valid: " + e.getMessage());
    }

    if (valid) {
        System.out.println("Program is valid.");
    } else {
        System.out.println("Program is not valid.");
}
  }

/*
 * Parser grammar rules
 */
  static final public void Program() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      ClassDeclaration();
    }
  }

  static final public void ClassDeclaration() throws ParseException {
    jj_consume_token(CLASS);
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EXTENDS:
      jj_consume_token(EXTENDS);
      jj_consume_token(ID);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(LBRACE);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VOID:
      case STRING:
      case BOOLEAN:
      case INT:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      VarDeclaration();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PUBLIC:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      MethodDeclaration();
    }
    jj_consume_token(RBRACE);
  }

  static final public void VarDeclaration() throws ParseException {
    Type();
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUAL:
      jj_consume_token(EQUAL);
      Exp();
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void MethodDeclaration() throws ParseException {
    jj_consume_token(PUBLIC);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STATIC:
      jj_consume_token(STATIC);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    Type();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
    case MAIN:
      jj_consume_token(MAIN);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
    case STRING:
    case BOOLEAN:
    case INT:
      Type();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
        jj_consume_token(LBRACKET);
        jj_consume_token(RBRACKET);
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      jj_consume_token(ID);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
        jj_consume_token(COMMA);
        Type();
        jj_consume_token(ID);
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VOID:
      case STRING:
      case BOOLEAN:
      case INT:
      case IF:
      case WHILE:
      case PRINT:
      case THIS:
      case ID:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_5;
      }
      Statement();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RETURN:
      jj_consume_token(RETURN);
      Exp();
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
  }

  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      IfStatement();
      break;
    case WHILE:
      WhileStatement();
      break;
    case PRINT:
      PrintStatement();
      break;
    default:
      jj_la1[13] = jj_gen;
      if (jj_2_1(2)) {
        AssignmentStatement();
      } else if (jj_2_2(2)) {
        VarDeclaration();
      } else if (jj_2_3(2)) {
        ClassInstantiation();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case VOID:
        case STRING:
        case BOOLEAN:
        case INT:
          ArrayDeclaration();
          break;
        case ID:
          MethodCall();
          break;
        default:
          jj_la1[14] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static final public void IfStatement() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    Exp();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VOID:
      case STRING:
      case BOOLEAN:
      case INT:
      case IF:
      case WHILE:
      case PRINT:
      case THIS:
      case ID:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_6;
      }
      Statement();
    }
    jj_consume_token(RBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      jj_consume_token(LBRACE);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case VOID:
        case STRING:
        case BOOLEAN:
        case INT:
        case IF:
        case WHILE:
        case PRINT:
        case THIS:
        case ID:
          ;
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_7;
        }
        Statement();
      }
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
  }

  static final public void WhileStatement() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    Exp();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VOID:
      case STRING:
      case BOOLEAN:
      case INT:
      case IF:
      case WHILE:
      case PRINT:
      case THIS:
      case ID:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_8;
      }
      Statement();
    }
    jj_consume_token(RBRACE);
  }

  static final public void PrintStatement() throws ParseException {
    jj_consume_token(PRINT);
    jj_consume_token(LPAREN);
    jj_consume_token(STRING_LITERAL);
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

  static final public void AssignmentStatement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      AssignmentStatementA();
      break;
    case THIS:
      jj_consume_token(THIS);
      jj_consume_token(DOT);
      jj_consume_token(ID);
      jj_consume_token(EQUAL);
      Exp16();
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void AssignmentStatementA() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACKET:
      jj_consume_token(LBRACKET);
      Exp();
      jj_consume_token(RBRACKET);
      jj_consume_token(EQUAL);
      Exp();
      jj_consume_token(SEMICOLON);
      break;
    case EQUAL:
      jj_consume_token(EQUAL);
      Exp();
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ClassInstantiation() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(ID);
    jj_consume_token(EQUAL);
    jj_consume_token(NEW);
    jj_consume_token(ID);
    jj_consume_token(LPAREN);
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

  static final public void ArrayDeclaration() throws ParseException {
    Type();
    jj_consume_token(LBRACKET);
    jj_consume_token(RBRACKET);
    jj_consume_token(ID);
    jj_consume_token(EQUAL);
    jj_consume_token(NEW);
    Type();
    jj_consume_token(LBRACKET);
    Exp();
    jj_consume_token(RBRACKET);
    jj_consume_token(SEMICOLON);
  }

  static final public void MethodCall() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(DOT);
    jj_consume_token(ID);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
    case NUMBER:
    case TRUE:
    case FALSE:
    case THIS:
    case NOT:
    case ID:
      ExpList();
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

  static final public void Exp() throws ParseException {
    Exp9();
  }

  static final public void Exp9() throws ParseException {
    Exp10();
    Exp9a();
  }

  static final public void Exp9a() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ADD_OP:
      jj_consume_token(ADD_OP);
      Exp10();
      Exp9a();
      break;
    case MINUS_OP:
      jj_consume_token(MINUS_OP);
      Exp10();
      Exp9a();
      break;
    default:
      jj_la1[22] = jj_gen;

    }
  }

  static final public void Exp10() throws ParseException {
    Exp11();
    Exp10a();
  }

  static final public void Exp10a() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LESS_THAN:
    case GREATER_THAN:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LESS_THAN:
        jj_consume_token(LESS_THAN);
        break;
      case GREATER_THAN:
        jj_consume_token(GREATER_THAN);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      Exp11();
      Exp10a();
      break;
    default:
      jj_la1[24] = jj_gen;

    }
  }

  static final public void Exp11() throws ParseException {
    Exp12();
    Exp11a();
  }

  static final public void Exp11a() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULT_OP:
      jj_consume_token(MULT_OP);
      Exp12();
      Exp11a();
      break;
    case DIV_OP:
      jj_consume_token(DIV_OP);
      Exp12();
      Exp11a();
      break;
    default:
      jj_la1[25] = jj_gen;

    }
  }

  static final public void Exp12() throws ParseException {
    Exp13();
    Exp12a();
  }

  static final public void Exp12a() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
      jj_consume_token(AND);
      Exp13();
      Exp12a();
      break;
    default:
      jj_la1[26] = jj_gen;

    }
  }

  static final public void Exp13() throws ParseException {
    Exp16();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NEW:
    case LBRACKET:
    case DOT:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
        jj_consume_token(LBRACKET);
        Exp();
        jj_consume_token(RBRACKET);
        break;
      case DOT:
        jj_consume_token(DOT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LENGTH:
          jj_consume_token(LENGTH);
          break;
        default:
          jj_la1[27] = jj_gen;
          if (jj_2_4(2)) {
            jj_consume_token(ID);
            jj_consume_token(LPAREN);
            ExpList();
            jj_consume_token(RPAREN);
          } else {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case ID:
              jj_consume_token(ID);
              break;
            default:
              jj_la1[28] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
          }
        }
        break;
      case NEW:
        jj_consume_token(NEW);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT:
          jj_consume_token(INT);
          jj_consume_token(LBRACKET);
          Exp();
          jj_consume_token(RBRACKET);
          break;
        case ID:
          jj_consume_token(ID);
          jj_consume_token(LPAREN);
          jj_consume_token(RPAREN);
          break;
        default:
          jj_la1[29] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[31] = jj_gen;
      ;
    }
  }

  static final public void Exp16() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      t = jj_consume_token(NUMBER);
      break;
    case ID:
      t = jj_consume_token(ID);
      break;
    case TRUE:
      t = jj_consume_token(TRUE);
      break;
    case FALSE:
      t = jj_consume_token(FALSE);
      break;
    case NOT:
      jj_consume_token(NOT);
      Exp16();
      break;
    case THIS:
      jj_consume_token(THIS);
      jj_consume_token(DOT);
      jj_consume_token(ID);
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      Exp();
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[32] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ExpList() throws ParseException {
    Exp();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[33] = jj_gen;
        break label_9;
      }
      jj_consume_token(COMMA);
      Exp();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_3R_12() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_3R_15()) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_scan_token(EQUAL)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    return false;
  }

  static private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(15)) {
    jj_scanpos = xsp;
    if (jj_scan_token(14)) {
    jj_scanpos = xsp;
    if (jj_scan_token(8)) {
    jj_scanpos = xsp;
    if (jj_scan_token(11)) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_scan_token(THIS)) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_scan_token(ID)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MiniJavaParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  /** Whether we are looking ahead. */
  static private boolean jj_lookingAhead = false;
  static private boolean jj_semLA;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[34];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20,0x1000,0xc900,0x40,0x200000,0x80,0x400,0x1000000,0x0,0xc900,0xdc900,0x2000,0xc900,0xd0000,0xc900,0xdc900,0xdc900,0x20000,0xdc900,0x0,0x1200000,0x400000,0x18000000,0x0,0x0,0x60000000,0x0,0x80000000,0x0,0x8000,0x1000200,0x1000200,0x400000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x800000,0x0,0x40,0x0,0x800010,0x0,0x0,0x0,0x800000,0x800010,0x800010,0x0,0x800010,0x800010,0x0,0x80003e,0x0,0x600,0x600,0x0,0x2000,0x0,0x800000,0x800000,0x1,0x1,0x80003e,0x40,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[4];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public MiniJavaParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MiniJavaParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MiniJavaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public MiniJavaParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MiniJavaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public MiniJavaParser(MiniJavaParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MiniJavaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[58];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 34; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 58; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
