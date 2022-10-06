# capacitor-share-with-plugin

This plugin allows you to share files from your device's file explorer with your capacitor app

## Install

```bash
npm install capacitor-share-with-plugin
npx cap sync android
```

## API

<docgen-index>

- [capacitor-share-with-plugin](#capacitor-share-with-plugin)
  - [Install](#install)
  - [API](#api)
    - [addListener('FILE_SINGLE' | 'FILE_MULTIPLE', ...)](#addlistenerfile_single--file_multiple-)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### addListener('FILE_SINGLE' | 'FILE_MULTIPLE', ...)

```typescript
addListener(eventName: 'FILE_SINGLE' | 'FILE_MULTIPLE', listenerFunc: (event: any) => void) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                          | Description                                           |
| ------------------ | --------------------------------------------- | ----------------------------------------------------- |
| **`eventName`**    | <code>'FILE_SINGLE' \| 'FILE_MULTIPLE'</code> | - Name of the event to listen to                      |
| **`listenerFunc`** | <code>(event: any) =&gt; void</code>          | - The callback that is executed when the event occurs |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------

</docgen-api>
