package mj.apps.rxandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
        // It will get only 4 and onComplete
        asyncSubject.subscribe(getFirstObserver());
        asyncSubject.onNext(1);
        asyncSubject.onNext(2);
        asyncSubject.onNext(3);
        // It will also get only get 4 and onComplete
        asyncSubject.subscribe(getSecondObserver());
        asyncSubject.onNext(4);
        asyncSubject.onComplete();
    }
    
    private Observer<Integer> getFirstObserver() {
        Observer<Integer> firstObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "First " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        };
        return firstObserver;
    }
    
    private Observer<Integer> getSecondObserver() {
        Observer<Integer> secondObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "Second " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        };
        return secondObserver;
    }
}
