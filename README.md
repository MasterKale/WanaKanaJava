WanaKanaJava
============

I converted WanaKana (https://github.com/wanikani/wanakana) to Java for use in Android projects. I targeted SDK 14 and up, but this'll probably work with prior versions of Android as well.

Usage
============
Here's how to instantiate the class:
```java
// Pass in an EditText and a boolean to indicate whether or not you want to use obsolete kana such as ゐ and ゑ
EditText et = (EditText) findViewById(R.id.editText);
WanaKanaJava wkj = new WanaKanaJava(et, false);
```

The methods described on WanaKana's documentation (https://github.com/WaniKani/WanaKana/blob/master/README.md#documentation) should all work in the same manner. I took some slight liberties on bind() and unbind(), though -  you don't need to pass anything along when you call them:
```java
// Binds a TextWatcher to the EditText so any text input is converted
WanaKanaJava.bind();

// Unbinds the TextWatcher from the EditText
WanaKanaJava.unbind();

// Returns false if string contains mixed characters, otherwise true if Hiragana.
WanaKanaJava.isHiragana(String);

// Returns false if string contains characters outside of the kana family, otherwise true if Hiragana and/or Katakana.
WanaKanaJava.isKana(String);

//Returns false if string contains mixed characters, otherwise true if Katakana.
WanaKanaJava.isKatakana(String);

// Convert Katakana or Romaji to Hiragana.
WanaKanaJava.toHiragana(String);

// Convert Romaji to Kana. Lowcase entries output Hiragana, while upcase entries output Katakana.
WanaKanaJava.toKana(String);

// Convert Hiragana or Romaji to Katakana.
WanaKanaJava.toKatakana(String);

// Convert Kana to Romaji.
WanaKanaJava.toRomaji(String);
```

Screenshot
==========
I included a sample app so you can see a practical implementation of WanaKanaJava. Here's a screenshot of that app
in action on a Nexus 7 running 4.3: 
![Imgur](http://i.imgur.com/LvTuVqY.png)
