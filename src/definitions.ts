import type { PluginListenerHandle } from '@capacitor/core';

export interface ShareWithPlugin {

  /**
   * @param eventName {string} Name of the event to listen.
   * @param {listenerFunc} listenerFunc Callback to be executed when the event occurs.
   */
  addListener(eventName: 'FILE_SINGLE', listenerFunc: (event: FileDetails) => void): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * @param eventName {string} Name of the event to listen.
   * @param {listenerFunc} listenerFunc Callback to be executed when the event occurs.
   */
  addListener(eventName: 'FILE_MULTIPLE', listenerFunc: (event: FileDetails[]) => void): Promise<PluginListenerHandle> & PluginListenerHandle;
}

export interface FileDetails {

  /**
   * URI of the file.
   */
    uri: string,

  /**
   * Extension of the file.
   */
    ext: string
}
