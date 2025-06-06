package practicum.module_2.lesson.String.Task_7;

public class TextFixer {
    public String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String fixText(String text) {
        // Реализуйте этот метод
        text=text.replace("„","«");
        text=text.replace("“","»");
        text=text.replace("цевилизаций","цивилизаций");
        text.trim();
        text= capitalize(text);
        return text;
    }

    public static void main(String[] args) {

        String text = "    история каждой из крупных галактических цевилизаций может быть разделена на три различные, " +
                "ярко выраженные фазы: Борьба за выживание, Любопытство и Утонченность, также именуемые фазами " +
                "„Как?“, „Зачем?“ и „Где?“. Пример: если для первой фазы характерен вопрос: „Как бы нам поесть?“," +
                " а для второй „Зачем мы едим?“, то третья отличается вопросом: „Где бы нам лучше поужинать?“.   ";

        var textFixer = new TextFixer();
        var fixedText = textFixer.fixText(text);
        System.out.println(fixedText);
    }
}
