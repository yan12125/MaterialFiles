/*
 * Copyright (c) 2026 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.files.provider.common

import java8.nio.file.OpenOption
import java8.nio.file.Path
import java8.nio.file.attribute.FileTime
import java.io.IOException
import java.io.OutputStream

// Implemented by providers that can only preserve a file's last modified time if it's known
// before the upload starts (e.g. WebDAV's X-OC-MTime header, which must be sent with the PUT
// request), unlike the usual write-then-setLastModifiedTime() pattern used elsewhere.
interface MtimePreservingFileSystemProvider {
    @Throws(IOException::class)
    fun newOutputStream(
        file: Path,
        lastModifiedTime: FileTime?,
        vararg options: OpenOption
    ): OutputStream
}
