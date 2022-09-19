import { registerPlugin } from '@capacitor/core';

import type { ShareWithPlugin } from './definitions';

const ShareWith = registerPlugin<ShareWithPlugin>('ShareWith', {
  web: () => import('./web').then(m => new m.ExampleWeb()),
});

export * from './definitions';
export { ShareWith };
