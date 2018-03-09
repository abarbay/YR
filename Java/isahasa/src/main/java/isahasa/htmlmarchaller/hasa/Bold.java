package isahasa.htmlmarchaller.hasa;


import isahasa.htmlmarchaller.TextSource;

public class Bold extends TextDecorator {



    public Bold(TextSource textSource) {
        this.textSource=textSource;
    }

    @Override
    public String getPlainText() {
        return "<b>"+this.textSource.getPlainText()+"</b>";
    }
}