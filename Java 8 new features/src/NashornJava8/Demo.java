package NashornJava8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo {

  public static void main(String[] args)
    throws FileNotFoundException, NoSuchMethodException {
    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
    try {
      //   engine.eval("print('Hemlo..')");
      engine.eval(new FileReader("src\\NashornJava8\\demo.js"));
      Invocable invocable = (Invocable) engine;
      Object res = invocable.invokeFunction("fun1", "Martin");
      System.out.println(res);
    } catch (ScriptException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
