[libui.ktx](../index.md) / [AttributedString](index.md) / [insert](./insert.md)

# insert

`fun insert(str: String, at: Int): Unit`

Adds the '\\0'-terminated UTF-8 string `str` at the byte position specified by `at`.
The new substring will be unattributed existing attributes will be moved along with their text.

