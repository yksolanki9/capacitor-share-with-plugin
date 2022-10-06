import type { PluginListenerHandle } from '@capacitor/core';

export interface ShareWithPlugin {
  /**
   * @param eventName {string} - Name of the event to listen.
   * @param {listenerFunc} listenerFunc - The callback that is executed when the event occurs.
   */
  addListener(eventName: 'FILE_SINGLE' | 'FILE_MULTIPLE', listenerFunc: (event: any) => void): Promise<PluginListenerHandle> & PluginListenerHandle;
}
