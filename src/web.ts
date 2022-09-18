import { WebPlugin } from '@capacitor/core';

import type { ShareWithPlugin } from './definitions';

export class ExampleWeb extends WebPlugin implements ShareWithPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
