package defpackage;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import androidx.fragment.app.DialogFragment;
import cris.org.in.prs.ima.R;
import java.util.Calendar;

/* renamed from: Rl  reason: default package */
/* compiled from: MonthYearPickerDialog */
public class Rl extends DialogFragment {
    public DatePickerDialog.OnDateSetListener a;

    /* renamed from: Rl$a */
    /* compiled from: MonthYearPickerDialog */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Rl.this.getDialog().cancel();
        }
    }

    /* renamed from: Rl$b */
    /* compiled from: MonthYearPickerDialog */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ NumberPicker f3784a;
        public final /* synthetic */ NumberPicker b;

        public b(NumberPicker numberPicker, NumberPicker numberPicker2) {
            this.f3784a = numberPicker;
            this.b = numberPicker2;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Rl.this.a.onDateSet((DatePicker) null, this.f3784a.getValue(), this.b.getValue(), 0);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        Calendar instance = Calendar.getInstance();
        View inflate = layoutInflater.inflate(R.layout.date_picker_dialog, (ViewGroup) null);
        NumberPicker numberPicker = (NumberPicker) inflate.findViewById(R.id.picker_month);
        NumberPicker numberPicker2 = (NumberPicker) inflate.findViewById(R.id.picker_year);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(12);
        numberPicker.setValue(instance.get(2) + 1);
        int i = instance.get(1);
        numberPicker2.setMinValue(i);
        numberPicker2.setMaxValue(2099);
        numberPicker2.setValue(i);
        builder.setView(inflate).setPositiveButton(R.string.ok, new b(numberPicker2, numberPicker)).setNegativeButton(R.string.cancel, new a());
        return builder.create();
    }
}
