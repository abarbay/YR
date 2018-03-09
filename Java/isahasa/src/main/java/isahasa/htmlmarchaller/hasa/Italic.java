package isahasa.htmlmarchaller.hasa;


import isahasa.htmlmarchaller.TextSource;

public class Italic extends TextDecorator {


    public Italic(TextSource textSource) {
        this.textSource=textSource;
    }

    @Override
    public String getPlainText() {
        return "<i>"+this.textSource.getPlainText()+"</i>";
    }
}
