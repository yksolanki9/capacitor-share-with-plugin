import type { PluginListenerHandle } from '@capacitor/core';

export interface ShareWithPlugin {

  /**
   * @callback listenerFunc - The callback that is executed when the event occurs
   */

  /**
   * @param eventName {string} - Name of the event to listen to
   * @param {listenerFunc} listenerFunc - The callback that is executed when the event occurs 
   */
  addListener(eventName: 'imageShared', listenerFunc: (event: any) => void): Promise<PluginListenerHandle> & PluginListenerHandle;
}
