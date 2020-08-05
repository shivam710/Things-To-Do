package com.example.thingstodo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.thingstodo.Word;

import java.util.List;

import static com.example.thingstodo.WordRoomDatabase.getDatabase;

public class WordRepository {

    private com.example.thingstodo.WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        com.example.thingstodo.WordRoomDatabase db = getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private com.example.thingstodo.WordDao mAsyncTaskDao;

        insertAsyncTask(com.example.thingstodo.WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private com.example.thingstodo.WordDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(com.example.thingstodo.WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
    private static class deleteWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private com.example.thingstodo.WordDao mAsyncTaskDao;

        deleteWordAsyncTask(com.example.thingstodo.WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.deleteWord(params[0]);
            return null;
        }
    }
//    private static class swapWordAsyncTask extends AsyncTask<String,String,Void> {
//        private com.example.thingstodo.WordDao mAsyncTaskDao;
//
//        swapWordAsyncTask(com.example.thingstodo.WordDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final String... params) {
//            mAsyncTaskDao.swapWord(params[0],params[1]);
//            return null;
//        }
//    }
    public void deleteAll()  {
        new deleteAllWordsAsyncTask(mWordDao).execute();
    }
    public void deleteWord(Word word)  {
        new deleteWordAsyncTask(mWordDao).execute(word);
    }
//    public void swapWord(String word1,String word2)  {
//        new swapWordAsyncTask(mWordDao).execute(word1,word2);
//    }
}
