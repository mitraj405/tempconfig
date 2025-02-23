package androidx.core.view.accessibility;

import android.view.View;

public interface AccessibilityViewCommand {

    public static abstract class CommandArguments {
    }

    public static final class a extends CommandArguments {
    }

    public static final class b extends CommandArguments {
    }

    public static final class c extends CommandArguments {
    }

    public static final class d extends CommandArguments {
    }

    public static final class e extends CommandArguments {
    }

    public static final class f extends CommandArguments {
    }

    public static final class g extends CommandArguments {
    }

    boolean perform(View view, CommandArguments commandArguments);
}
