package src.org.young.jvm;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;

/**
 * 简易的Eclipse插件程序
 * 		显示 Eclipse 的启动时间
 * 
 * @author by Young.ZHU on 2014年3月28日 
 *
 * 
 * Package&FileName: src.org.young.jvm.ShowTime
 */
public class ShowTime implements IStartup {

	@Override
	public void earlyStartup() {

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				long startTime = Long.parseLong(System
						.getProperty("eclipse.startTime"));
				long costTime = System.currentTimeMillis() - startTime;

				double dCostTime = costTime / 1000.0;

				Shell shell = Display.getDefault().getActiveShell();

				String msg = "Eclipse 启动耗时： " + dCostTime + " 秒！";

				MessageDialog.openInformation(shell, "Information", msg);
			}
		});
	}

}
