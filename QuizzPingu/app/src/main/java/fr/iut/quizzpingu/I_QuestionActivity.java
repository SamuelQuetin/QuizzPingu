package fr.iut.quizzpingu;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public interface I_QuestionActivity {
    public TextView question = null;
    static List<Question> listquestion = new ArrayList<Question>();
}
