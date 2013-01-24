package newfethers.java6.script.js;

import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestRunJs {
	public static String test() throws Exception {
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		ScriptEngine js = scriptManager.getEngineByExtension("js");
		js.eval("function test(num){ num.add('s');num.add('s2'); return num}");

		Invocable inv = (Invocable) js;
		List<String> list = new ArrayList<String>();
		String p1 = inv.invokeFunction("test", list).toString();
		System.out.println("l:" + list);
		return p1;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(test());
	}
}
