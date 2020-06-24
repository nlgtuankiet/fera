package com.nlgtuankiet.fera.domain.entity

import org.junit.Test

class PathTest {
  @Test
  fun `parent correct`() {
    val path = "/storageA/file1/file2".asPath()
    val parent = "/storageA/file1".asPath()
    assert(path.parent == parent)
  }

  @Test
  fun `parent correct 2`() {
    val path = "/storageA/file1/file2/".asPath()
    val parent = "/storageA/file1".asPath()
    assert(path.parent == parent)
  }

  @Test
  fun `name correct 1`() {
    val path = "/storageA/file1/file2/".asPath()
    assert(path.name == "file2")
  }

  @Test
  fun `name correct 2`() {
    val path = "/storageA/file1/file2".asPath()
    assert(path.name == "file2")
  }
}
