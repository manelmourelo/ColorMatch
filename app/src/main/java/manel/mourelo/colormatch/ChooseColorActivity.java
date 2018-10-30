package manel.mourelo.colormatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class ChooseColorActivity extends AppCompatActivity {

    // Model
    private List<Integer> colors = Arrays.asList(
        0xFFFFFFFF, 0xFFFFFFF0, 0xFFFFFFE0, 0xFFFFFF00, 0xFFFFFAFA,
        0xFFFFFAF0, 0xFFFFFACD, 0xFFFFF8DC, 0xFFFFF5EE, 0xFFFFF0F5,
        0xFFFFEFD5, 0xFFFFEBCD, 0xFFFFE4E1, 0xFFFFE4C4, 0xFFFFE4B5,
        0xFFFFDEAD, 0xFFFFDAB9, 0xFFFFD700, 0xFFFFC0CB, 0xFFFFB6C1,
        0xFFFFA500, 0xFFFFA07A, 0xFFFF8C00, 0xFFFF7F50, 0xFFFF69B4,
        0xFFFF6347, 0xFFFF4500, 0xFFFF1493, 0xFFFF00FF, 0xFFFF00FF,
        0xFFFF0000, 0xFFFDF5E6, 0xFFFAFAD2, 0xFFFAF0E6, 0xFFFAEBD7,
        0xFFFA8072, 0xFFF8F8FF, 0xFFF5FFFA, 0xFFF5F5F5, 0xFFF5F5DC,
        0xFFF5DEB3, 0xFFF4A460, 0xFFF0FFFF, 0xFFF0FFF0, 0xFFF0F8FF,
        0xFFF0E68C, 0xFFF08080, 0xFFEEE8AA, 0xFFEE82EE, 0xFFE9967A,
        0xFFE6E6FA, 0xFFE0FFFF, 0xFFDEB887, 0xFFDDA0DD, 0xFFDCDCDC,
        0xFFDC143C, 0xFFDB7093, 0xFFDAA520, 0xFFDA70D6, 0xFFD8BFD8,
        0xFFD3D3D3, 0xFFD2B48C, 0xFFD2691E, 0xFFCD853F, 0xFFCD5C5C,
        0xFFC71585, 0xFFC0C0C0, 0xFFBDB76B, 0xFFBC8F8F, 0xFFBA55D3,
        0xFFB8860B, 0xFFB22222, 0xFFB0E0E6, 0xFFB0C4DE, 0xFFAFEEEE,
        0xFFADFF2F, 0xFFADD8E6, 0xFFA9A9A9, 0xFFA52A2A, 0xFFA0522D,
        0xFF9ACD32, 0xFF9932CC, 0xFF98FB98, 0xFF9400D3, 0xFF9370DB,
        0xFF90EE90, 0xFF8FBC8F, 0xFF8B4513, 0xFF8B008B, 0xFF8B0000,
        0xFF8A2BE2, 0xFF87CEFA, 0xFF87CEEB, 0xFF808080, 0xFF808000,
        0xFF800080, 0xFF800000, 0xFF7FFFD4, 0xFF7FFF00, 0xFF7CFC00,
        0xFF7B68EE, 0xFF778899, 0xFF708090, 0xFF6B8E23, 0xFF6A5ACD,
        0xFF696969, 0xFF66CDAA, 0xFF6495ED, 0xFF5F9EA0, 0xFF556B2F,
        0xFF4B0082, 0xFF48D1CC, 0xFF483D8B, 0xFF4682B4, 0xFF4169E1,
        0xFF40E0D0, 0xFF3CB371, 0xFF32CD32, 0xFF2F4F4F, 0xFF2E8B57,
        0xFF228B22, 0xFF20B2AA, 0xFF1E90FF, 0xFF191970, 0xFF00FFFF,
        0xFF00FFFF, 0xFF00FF7F, 0xFF00FF00, 0xFF00FA9A, 0xFF00CED1,
        0xFF00BFFF, 0xFF008B8B, 0xFF008080, 0xFF008000, 0xFF006400,
        0xFF0000FF, 0xFF0000CD, 0xFF00008B, 0xFF000080, 0xFF000000
    );

    // Referències a objectes de la pantalla
    private RecyclerView colorlist_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creem el View per un ítem programàticament... (no hi ha fitxer de layout ;)
        colorlist_view = new RecyclerView(this);
        colorlist_view.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.MATCH_PARENT
        ));
        setContentView(colorlist_view); // coloquem el root

        colorlist_view.setLayoutManager(new GridLayoutManager(this, 6));
        colorlist_view.setAdapter(new ColorListAdapter());
    }

    void onColorSelect(int position) {
        int color = colors.get(position);
        Intent data = new Intent();
        data.putExtra("color", color);
        setResult(RESULT_OK, data);
        finish();
    }

    private class ColorViewHolder extends RecyclerView.ViewHolder {
        View color_view;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            color_view = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onColorSelect(getAdapterPosition());
                }
            });
        }
    }

    private class ColorListAdapter extends RecyclerView.Adapter<ColorViewHolder> {
        @NonNull
        @Override
        public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            // Creem el View per un ítem programàticament... (no hi ha fitxer de layout ;)
            int side = parent.getWidth() / 6;
            View view = new View(ChooseColorActivity.this);
            view.setLayoutParams(new ViewGroup.LayoutParams(side, side));
            return new ColorViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ColorViewHolder holder, int i) {
            holder.color_view.setBackgroundColor(colors.get(i));
        }

        @Override
        public int getItemCount() {
            return colors.size();
        }
    }
}
