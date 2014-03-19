ShowTime implements IStartup {
  public void earlyStartup() {
    Display.getDefault().syncExec(new Runnable() {
      public void run()  {
        long startTime = Long.parseLong(System.getProperty("eclipse.startTime"));
        long costTime = System.currentTimeMillis() - startTime;
        Shell shell = Display.getDefualt().getActiveShell();
         
        String msg = "Eclipse 启动耗时：" + costTime ;
        
        MessageDialog.openInfomation(shell, "Information", msg);
      }
    });
  }
}
