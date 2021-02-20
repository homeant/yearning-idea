package com.github.homeant.yearning.vfs;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.vfs.*;
import com.intellij.util.KeyedLazyInstanceEP;
import org.jetbrains.annotations.*;

import java.io.IOException;

public class YearningFileSystem extends VirtualFileSystem {

    /**
     * Gets the protocol for this file system. Protocols should differ for all file systems.
     * Should be the same as corresponding {@link KeyedLazyInstanceEP#key}.
     *
     * @return String representing the protocol
     * @see VirtualFile#getUrl
     * @see VirtualFileManager#getFileSystem
     */
    @Override
    public @NonNls
    @NotNull String getProtocol() {
        return "Yearning";
    }

    /**
     * Searches for the file specified by given path. Path is a string which uniquely identifies file within given
     * {@link VirtualFileSystem}. Format of the path depends on the concrete file system.
     * For {@code LocalFileSystem} it is an absolute path (both Unix- and Windows-style separator chars are allowed).
     *
     * @param path the path to find file by
     * @return a virtual file if found, {@code null} otherwise
     */
    @Override
    public @Nullable VirtualFile findFileByPath(@NotNull @NonNls String path) {
        return null;
    }

    /**
     * Refreshes the cached information for all files in this file system from the physical file system.<p>
     * <p/>
     * If {@code asynchronous} is {@code false} this method should be only called within write-action.
     * See {@link Application#runWriteAction}.
     *
     * @param asynchronous if {@code true} then the operation will be performed in a separate thread,
     *                     otherwise will be performed immediately
     * @see VirtualFile#refresh
     * @see VirtualFileManager#syncRefresh
     * @see VirtualFileManager#asyncRefresh
     */
    @Override
    public void refresh(boolean asynchronous) {

    }

    /**
     * Refreshes only the part of the file system needed for searching the file by the given path and finds file
     * by the given path.<br>
     * <p/>
     * This method is useful when the file was created externally and you need to find <code>{@link VirtualFile}</code>
     * corresponding to it.<p>
     * <p/>
     * If this method is invoked not from Swing event dispatch thread, then it must not happen inside a read action. The reason is that
     * then the method call won't return until proper VFS events are fired, which happens on Swing thread and in write action. So invoking
     * this method in a read action would result in a deadlock.
     *
     * @param path the path
     * @return <code>{@link VirtualFile}</code> if the file was found, {@code null} otherwise
     */
    @Override
    public @Nullable VirtualFile refreshAndFindFileByPath(@NotNull String path) {
        return null;
    }

    /**
     * Adds listener to the file system. Normally one should use {@link VirtualFileManager#VFS_CHANGES} message bus topic.
     *
     * @param listener the listener
     * @see VirtualFileListener
     * @see VirtualFileManager#VFS_CHANGES
     */
    @Override
    public void addVirtualFileListener(@NotNull VirtualFileListener listener) {

    }

    /**
     * Removes listener form the file system.
     *
     * @param listener the listener
     */
    @Override
    public void removeVirtualFileListener(@NotNull VirtualFileListener listener) {

    }

    /**
     * Implementation of deleting files in this file system
     *
     * @param requestor
     * @param vFile
     * @see VirtualFile#delete(Object)
     */
    @Override
    protected void deleteFile(Object requestor, @NotNull VirtualFile vFile) throws IOException {
        vFile.delete(requestor);
    }

    /**
     * Implementation of moving files in this file system
     *
     * @param requestor
     * @param vFile
     * @param newParent
     * @see VirtualFile#move(Object, VirtualFile)
     */
    @Override
    protected void moveFile(Object requestor, @NotNull VirtualFile vFile, @NotNull VirtualFile newParent) throws IOException {
        vFile.move(requestor,newParent);
    }

    /**
     * Implementation of renaming files in this file system
     *
     * @param requestor
     * @param vFile
     * @param newName
     * @see VirtualFile#rename(Object, String)
     */
    @Override
    protected void renameFile(Object requestor, @NotNull VirtualFile vFile, @NotNull String newName) throws IOException {
        vFile.rename(requestor,newName);
    }

    /**
     * Implementation of adding files in this file system
     *
     * @param requestor
     * @param vDir
     * @param fileName
     * @see VirtualFile#createChildData(Object, String)
     */
    @Override
    protected @NotNull VirtualFile createChildFile(Object requestor, @NotNull VirtualFile vDir, @NotNull String fileName) throws IOException {
        return vDir.createChildData(requestor,fileName);
    }

    /**
     * Implementation of adding directories in this file system
     *
     * @param requestor
     * @param vDir
     * @param dirName
     * @see VirtualFile#createChildDirectory(Object, String)
     */
    @Override
    protected @NotNull VirtualFile createChildDirectory(Object requestor, @NotNull VirtualFile vDir, @NotNull String dirName) throws IOException {
        return vDir.createChildDirectory(requestor,dirName);
    }

    /**
     * Implementation of copying files in this file system
     *
     * @param requestor
     * @param virtualFile
     * @param newParent
     * @param copyName
     * @see VirtualFile#copy(Object, VirtualFile, String)
     */
    @Override
    protected @NotNull VirtualFile copyFile(Object requestor, @NotNull VirtualFile virtualFile, @NotNull VirtualFile newParent, @NotNull String copyName) throws IOException {
        return virtualFile.copy(requestor,newParent,copyName);
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }
}
