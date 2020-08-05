package com.example.thingstodo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.thingstodo.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();
    @Delete
    void deleteWord(Word word);
//    @Query("UPDATE word_table SET word = case when word = :word1 then :word2 else :word1 end WHERE word in (:word1,:word2)")
//    void swapWord(String word1,String word2);
}
